package com.renyu.weixinedittext;

import android.app.Dialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import com.renyu.weixinedittext.adapter.MainAdapterJ;
import com.renyu.weixinedittext.bean.AbstractBean;
import com.renyu.weixinedittext.bean.BottomBean;
import com.renyu.weixinedittext.bean.NormalBean;
import com.renyu.weixinedittext.bean.TopBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taochen on 19-3-19.
 * Mail：935612713@qq.com
 */

public class MainActivityJ extends AppCompatActivity {

    private RecyclerView rv_content;
    private MainAdapterJ adapter;
    //包含输入框的 dialog
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_content = findViewById(R.id.rv_main);

        List<AbstractBean> beans = new ArrayList<>();
        beans.add(new TopBean());
        beans.add(new NormalBean("世界眼中的中国两会，是一道集聚全国人民磅礴之力的风景线，不仅展现着新时代中国的意气风发，而且增添着世界的生机和动能"));
        beans.add(new NormalBean("中国智慧、中国方略、中国成就集中展现，来自世界的热评此起彼伏。“中国两会对全球事务有着巨大影响力”“是时候对中国的突飞猛进有清醒的认识了”“中国方案为世界提供借鉴”……来自世界的这些叙述，折射着探寻成功秘诀的目光。各国媒体纷纷向北京增派记者，3000多名中外记者报名采访中国两会。世界瞩目中国两会，期待进一步读懂新时代的中国。"));
        beans.add(new NormalBean("作为世界最大发展中国家和第二大经济体，中国不断创造着人类发展史上惊天动地的奇迹。中国提供着最高的对世界经济增长的贡献率、最高的对世界减贫事业的贡献率，中国建成了世界上最大的社会保障网、高速铁路网，中国科技创新在诸多领域实现并跑、领跑……国际舆论普遍认为，着眼自身治理能力现代化的中国，日益为全球治理作出重要贡献。"));
        beans.add(new NormalBean("世界经济复苏发展，中国功不可没。中国国家统计局最新数据显示，2017年，中国国内生产总值增速达6.9%，占世界经济的比重达15%，稳居世界第二。“中国的成功故事与世界经济的命运紧密相连。”国际货币基金组织第一副总裁戴维·利普顿这样评价。“世行对中国经济发展有信心，对中国持续成为全球经济增长引擎有信心。”世界银行发展预测局局长阿伊汗·高斯为中国点赞"));
        beans.add(new NormalBean("国外不少人感叹，世界太需要像中国这样不断书写成功故事。但是，环顾当下的世界，一些国家深陷矛盾丛生、乱象频发的怪圈。在今年年初的达沃斯论坛年会和慕尼黑安全会议上，来自西方一些国家的人士纷纷大谈对社会分裂、政治极化、民粹主义盛行之忧。国际政治、社会领域诸多乱象，从若干侧面说明了失却方向之痛、道路探索之难。与此形成鲜明反差的是，中国的稳步发展和繁荣景象，无疑给不乏深忧的世界注入了昂扬振奋的力量。"));
        beans.add(new NormalBean("中国的成功故事，揭示了中国道路自信、理论自信、制度自信、文化自信之源。中共十九大的胜利召开，为中国建设现代化强国指明了方向，为中华民族伟大复兴做了全面谋划。世界瞩目，十九大后的首次中国两会将如何围绕民众普遍关心的反腐倡廉、社会保障、教育公平、医疗改革、脱贫攻坚、依法治国、改革开放等一系列议题谋篇布局，中国智慧如何为破解各国面临的共同难题提供启示。"));
        beans.add(new NormalBean("“立治有体，施治有序。”欧洲智库专家认为，中国在国家治理和推进改革方面展现的强大领导力，堪为世界各国推进改革的重要借鉴。不少报道过中国两会的外国记者表示，人大代表和政协委员积极为国家发展履职尽责、建言献策的情景让他们深刻体会到，中国的人民代表大会制度和中国共产党领导的多党合作和政治协商制度具有明显优越性，与西方一些执政党和反对党为了各自政治利益争论不休的场面有天壤之别。"));
        beans.add(new NormalBean("站在新的历史起点上，中国蓄势待发。世界眼中的中国两会，是一道集聚全国人民磅礴之力的风景线，不仅展现着新时代中国的意气风发，而且增添着世界的生机和动能。"));
        beans.add(new NormalBean("完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完完"));
        adapter = new MainAdapterJ(this, beans);
        rv_content.setLayoutManager(new LinearLayoutManager(this));
        rv_content.setAdapter(adapter);

        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                handleWindowChange();
            }
        });
    }

    /**
     * 监听键盘的显示和隐藏
     */
    private void handleWindowChange() {
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);//获取当前界面显示范围
        Log.i("display  ", "top = " + rect.top);
        Log.i("display  ", "bottom = " + rect.bottom);
        int displayHeight = rect.bottom - rect.top;//app内容显示高度，即屏幕高度-状态栏高度-键盘高度
        int totalHeight = getWindow().getDecorView().getHeight();
        //显示内容的高度和屏幕高度比大于 0.8 时，dismiss dialog
        if ((float) displayHeight / totalHeight > 0.8)//0.8只是一个大致的比例，可以修改
            if (null != dialog && dialog.isShowing()) {
                dialog.dismiss();
                //如果添加了空白 item ，移除空白 item
                if (adapter.getBeanList().get(adapter.getBeanList().size() - 1) instanceof BottomBean) {
                    adapter.getBeanList().remove(adapter.getBeanList().size() - 1);
                    adapter.notifyDataSetChanged();
                }
            }
    }

    /**
     * 显示评论输入 dialog
     *
     * @param itemView
     * @param position
     */
    public void showInputDialog(View itemView, final int position) {
        // RV中评论区起始Y的位置
        final int rvInputY = getCoordinateY(itemView);
        final int rvInputHeight = itemView.getHeight();

        dialog = new Dialog(this, android.R.style.Theme_Translucent_NoTitleBar);
        dialog.setContentView(R.layout.dialog_comment);
        //scrollView 点击事件，点击时将 dialog dismiss，设置 onClick 监听无效
        dialog.findViewById(R.id.scrollView).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP)
                    dialog.dismiss();
                return true;
            }
        });
        dialog.show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // 对话框中的输入框Y的位置
                int dialogY = getCoordinateY(dialog.findViewById(R.id.dialog_layout_comment));

                if (position == adapter.getBeanList().size() - 1) {
                    adapter.getBeanList().add(new BottomBean());
                    adapter.setBottomHeight(dialog.findViewById(R.id.dialog_layout_comment).getHeight());
                    adapter.notifyDataSetChanged();
                }
                rv_content.smoothScrollBy(0, rvInputY - dialogY + rvInputHeight);
            }
        }, 300);
    }

    /**
     * 获取控件左上顶点 y 坐标
     *
     * @param view
     * @return
     */
    private int getCoordinateY(View view) {
        int[] coordinate = new int[2];
        view.getLocationOnScreen(coordinate);
        return coordinate[1];
    }
}
