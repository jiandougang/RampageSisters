package com.jiandougang.rampagesisters.main.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiandougang.rampagesisters.R;
import com.jiandougang.rampagesisters.InsuraceProducts.InsuranceProductsDisplayActivity;
import com.jiandougang.rampagesisters.main.model.EvaluationListBean;

import java.util.ArrayList;

/**
 * 朋友圈图片apater
 * Created by wuguohong on 16/10/11.
 */

public class EvaluationPicAdapter extends RecyclerView.Adapter<EvaluationPicAdapter.EvaluationPicHolder> {

    private Context mContext;
    private ArrayList<EvaluationListBean.EvaluationPicBean> evaluationPicBeanList;

    public EvaluationPicAdapter(Context context, ArrayList<EvaluationListBean.EvaluationPicBean> evaluationPicBeanList) {
        this.mContext = context;
        this.evaluationPicBeanList = evaluationPicBeanList;

        for (int i = 0; i < 5; i++) {
            EvaluationListBean.EvaluationPicBean evaluationPicBean = new EvaluationListBean().new EvaluationPicBean();
            evaluationPicBean.imageUrl = "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=火影忍者&step_word=&hs=0&pn=6&spn=0&di=48931601730&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1859604817%2C164797118&os=1306749158%2C1034943018&simid=3571910011%2C550082037&adpicid=0&ln=1962&fr=&fmq=1476675442967_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201411%2F26%2F20141126210156_thKZ3.jpeg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3B17tpwg2_z%26e3Bv54AzdH3Fks52AzdH3F%3Ft1%3Dd09m9llab&gsm=0&rpstart=0&rpnum=0";
            evaluationPicBean.smallImageUrl = "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=火影忍者&step_word=&hs=0&pn=196&spn=0&di=162468510820&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=1758291215%2C738425935&os=2879591961%2C3073069190&simid=3398064340%2C432327713&adpicid=0&ln=1962&fr=&fmq=1476675442967_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fdmimg.5054399.com%2Fallimg%2F130724%2F31_130724155513_1.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3F14_z%26e3B9nll_z%26e3Bv54AzdH3Fi75ytg2AzdH3Fp5g26jgAzdH3Fda8na0d9-8080ld_z%26e3Bip4s&gsm=78&rpstart=0&rpnum=0";
            evaluationPicBeanList.add(evaluationPicBean);

        }

    }

    @Override
    public EvaluationPicAdapter.EvaluationPicHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_friend_circle_picture, parent, false);

        return new EvaluationPicAdapter.EvaluationPicHolder(view);
    }


    @Override
    public void onBindViewHolder(EvaluationPicAdapter.EvaluationPicHolder holder, final int position) {

        initEvent(holder, position);

    }

    private void initEvent(EvaluationPicAdapter.EvaluationPicHolder holder, final int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击查看大图
//                Intent intent = new Intent(mContext, RPSeeBigPictureActivity.class);
//                Bundle bundle = new Bundle();
//
//                bundle.putSerializable(RPSeeBigPictureActivity.PIC_DATA_LIST, evaluationPicBeanList);
//                intent.putExtras(bundle);
//                mContext.startActivity(intent);
//                ((RPMainActivity) mContext).overridePendingTransition(0, 0);


                switch (position) {

                    case 1:

                        Intent intent = new Intent(mContext,InsuranceProductsDisplayActivity.class);
                        mContext.startActivity(intent);
                        break;
                    default:
                        break;
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return 9;
    }


    public static class EvaluationPicHolder extends RecyclerView.ViewHolder {


        public EvaluationPicHolder(View itemView) {
            super(itemView);


        }
    }

}
