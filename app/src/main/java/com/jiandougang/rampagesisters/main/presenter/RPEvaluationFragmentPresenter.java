package com.jiandougang.rampagesisters.main.presenter;

import com.alibaba.fastjson.JSON;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.avos.avoscloud.GetCallback;
import com.jiandougang.rampagesisters.base.LeanCloudObjectClass;
import com.jiandougang.rampagesisters.base.model.file.RPFile;
import com.jiandougang.rampagesisters.base.model.user.RPUserBean;
import com.jiandougang.rampagesisters.main.model.RPEvaluationBean;
import com.jiandougang.rampagesisters.main.uiinterface.RPEvaluationFragmentUIInterface;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * RPEvaluationFragment逻辑处理类
 * Created by wuguohong on 16/9/13.
 */
public class RPEvaluationFragmentPresenter {


    public void findFriendCircleTakingfuck(final RPEvaluationFragmentUIInterface rpEvaluationFragmentUIInterface) {

        final int[] dataCount = new int[1];
        final ArrayList<RPEvaluationBean> rpEvaluationBeanArrayList = new ArrayList<>();

        Observable.create(new Observable.OnSubscribe<List<AVObject>>() {

            @Override
            public void call(final Subscriber<? super List<AVObject>> subscriber) {
                //查找说说说信息
                AVQuery<AVObject> query = new AVQuery<>(LeanCloudObjectClass.RPFriendCircle);
                query.findInBackground(new FindCallback<AVObject>() {
                    @Override
                    public void done(List<AVObject> list, AVException e) {

//                        List<AVObject> avobjectList = list;// 符合 priority = 0 的 Todo 数组
                        dataCount[0] = list.size();
                        subscriber.onNext(list);

                    }
                });
            }
        }).flatMap(new Func1<List<AVObject>, Observable<AVObject>>() {
            @Override
            public Observable<AVObject> call(List<AVObject> avobjectList) {
                return Observable.from(avobjectList);
            }
        }).flatMap(new Func1<AVObject, Observable<RPEvaluationBean>>() {

                       @Override
                       public Observable<RPEvaluationBean> call(final AVObject avobject) {

                           return Observable.create(new Observable.OnSubscribe<RPEvaluationBean>() {
                                                        @Override
                                                        public void call(final Subscriber<? super RPEvaluationBean> subscriber) {
                                                            final RPEvaluationBean evaluationBean = JSON.parseObject(avobject.toJSONObject().toString(), RPEvaluationBean.class);

                                                            //查找用户信息
                                                            AVObject user = AVObject.createWithoutData(LeanCloudObjectClass.RPFriendCircle, evaluationBean.getObjectId());
                                                            user.fetchInBackground("user", new GetCallback<AVObject>() {
                                                                @Override
                                                                public void done(AVObject avObject, AVException e) {
                                                                    AVObject user = avObject.getAVObject("user");
                                                                    RPUserBean userBean = JSON.parseObject(user.toJSONObject().toString(), RPUserBean.class);
                                                                    evaluationBean.setUser(userBean);


                                                                    subscriber.onNext(evaluationBean);

                                                                }
                                                            });
                                                        }
                                                    }

                           );
                       }
                   }

        ).doOnNext(new Action1<RPEvaluationBean>() {
            @Override
            public void call(final RPEvaluationBean evaluationBean) {
                //查找用户头像
                AVObject file = AVObject.createWithoutData(LeanCloudObjectClass.RPFile, evaluationBean.getUser().getHeadPortrait().getObjectId());
                file.fetchInBackground("", new GetCallback<AVObject>() {
                    @Override
                    public void done(AVObject avObject, AVException e) {
                        RPFile fileBean = JSON.parseObject(avObject.toJSONObject().toString(), RPFile.class);
                        evaluationBean.getUser().getHeadPortrait().setFile(fileBean);

//                                                                   subscriber.onNext(evaluationBean);
                    }
                });
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<RPEvaluationBean>() {
                               @Override
                               public void call(RPEvaluationBean evaluationBean) {
                                   rpEvaluationBeanArrayList.add(evaluationBean);

                                   if (rpEvaluationBeanArrayList.size() == dataCount[0]) {
                                       if (rpEvaluationFragmentUIInterface != null) {
                                           rpEvaluationFragmentUIInterface.upDateRecycleView(rpEvaluationBeanArrayList);
                                       }

                                   }
                               }
                           }
                );
    }
}
