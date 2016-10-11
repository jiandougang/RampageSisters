package com.jiandougang.rampagesisters.main.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.base.RPBaseFragment;
import com.jiandougang.rampagesisters.main.adapter.EvaluationAdapter;
import com.jiandougang.rampagesisters.main.model.RPEvaluationBean;
import com.jiandougang.rampagesisters.main.presenter.RPEvaluationFragmentPresenter;
import com.jiandougang.rampagesisters.main.uiinterface.RPEvaluationFragmentUIInterface;
import com.jiandougang.rampagesisters.main.view.recycleView.RecycleZoomView;

import java.util.ArrayList;

/**
 * 首页-旅游资讯
 * Created by wuguohong on 16/8/11.
 */
public class RPEvaluationFragment extends RPBaseFragment implements RPEvaluationFragmentUIInterface {

    private View view;
    private RecycleZoomView rcContent;
    private EvaluationAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<RPEvaluationBean> rpEvaluationBeanArrayList = new ArrayList<>();
    private RPEvaluationFragmentPresenter presenter = new RPEvaluationFragmentPresenter();


    public static RPEvaluationFragment newInstance() {
        return new RPEvaluationFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        initView(view);
        initData();
        return view;
    }


    private void initData() {
//        presenter.findFriendCircleTaking(rpEvaluationBeanArrayList, this);
        presenter.findFriendCircleTakingfuck(rpEvaluationBeanArrayList, this);


//        String[] strs = new String[]{"jack", "ann", "one", "two", "three", "four"};
//        Observable.from(strs)
//                .toList()
//                .subscribe(new Subscriber<List<String>>() {
//                    @Override
//                    public void onNext(List<String> names) {
//                        for (String name : names) {
//                            Log.e("toListTest", name);
//                        }
//                        Log.e("toListTest", "onNext");
//                    }
//
//                    @Override
//                    public void onCompleted() {
//                        Log.e("toListTest", "onCompleted");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("toListTest", "onError");
//                    }
//                });


//        AVObject guangZhou = new AVObject("City");// 广州
//        guangZhou.put("name", "广州");
//
//        AVObject guangDong = new AVObject("Province");// 广东
//        guangDong.put("name", "广东");
//
//        guangZhou.put("dependent", guangDong);// 为广州设置 dependent 属性为广东
//
//        guangZhou.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(AVException e) {
//                if (e == null) {
//                    // 广州被保存成功
//                }
//            }
//        });
//        // 广东无需被单独保存，因为在保存广州的时候已经上传到云端。

//        AVQuery<AVObject> query = new AVQuery<>(LeanCloudObjectClass.RPUser);
//        query.findInBackground(new FindCallback<AVObject>() {
//            @Override
//            public void done(List<AVObject> list, AVException e) {
//                List<AVObject> priorityEqualsZeroTodos = list;// 符合 priority = 0 的 Todo 数组
//
//                for (int i = 0; i < priorityEqualsZeroTodos.size(); i++) {
//                    KLog.json(priorityEqualsZeroTodos.get(i).toJSONObject().toString());
//                }
//            }
//        });

    }

    private void initView(View view) {
        adapter = new EvaluationAdapter(getContext());

        rcContent = (RecycleZoomView) view.findViewById(R.id.rv_message_content);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rcContent.setLayoutManager(layoutManager);
        rcContent.setAdapter(adapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void upDateRecycleView() {
        adapter.addEaluationDataAll(rpEvaluationBeanArrayList);
        rcContent.requestLayout();
    }
}
