package bawei.com.zdw_greendao_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bawei.com.zdwdb.WorkDaoHelp;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

        @BindView(R.id.button)
        Button button;
        @BindView(R.id.button2)
        Button button2;
        @BindView(R.id.button3)
        Button button3;
        @BindView(R.id.button4)
        Button button4;
        @BindView(R.id.btn_query_all)
        Button btnQueryAll;
        @BindView(R.id.button5)
        Button button5;
        @BindView(R.id.tv_content)
        TextView tvContent;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            initData();
        }

        private List<ZdwWork> zdwWorksList = new ArrayList<>();

        /**
         * 初始化数据
         */
        private void initData() {
            for (int i = 0; i < 100; i++) {
                ZdwWork zdwWork = new ZdwWork((long) i, "huang" + i, 25, "666" + i);
                zdwWorksList.add(zdwWork);
            }

        }

        int page;

        @OnClick({R.id.button, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.btn_query_all})
        public void onViewClicked(View view) {
            switch (view.getId()) {
                case R.id.button:
                    WorkDaoHelp.insertData(this, zdwWorksList);
                    break;
                case R.id.button2:
                    ZdwWork zdwWork = new ZdwWork((long) 5, "haung" + 5, 25, "123456");
                    /**
                     * 根据特定的对象删除
                     */
                    WorkDaoHelp.deleteData(this, zdwWork);
                    /**
                     * 根据主键删除
                     */
                    WorkDaoHelp.deleteByKeyData(this, 7);
                    WorkDaoHelp.deleteAllData(this);
                    break;
                case R.id.button3:
                    zdwWork = new ZdwWork((long) 2, "caojin", 1314, "888888");
                    WorkDaoHelp.updateData(this, zdwWork);
                    break;
                case R.id.button4:
                    List<ZdwWork> students = WorkDaoHelp.queryAll(this);
                    tvContent.setText(students.toString());
                    for (int i = 0; i < students.size(); i++) {
                        Log.i("Log", students.get(i).getName());
                    }

                    break;
                case R.id.button5:
                    WorkDaoHelp.deleteAllData(this);
                    break;
                case R.id.btn_query_all:
                    List<ZdwWork> students2 = WorkDaoHelp.queryPaging(page, 20, this);

                    if (students2.size() == 0) {
                        Toast.makeText(this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                    }
                    for (ZdwWork zw : students2) {
                        Log.e("TAG", "onViewClicked: ==" + zw);
                        Log.e("TAG", "onViewClicked: == num = " + zw.getNum());
                    }
                    page++;
                    tvContent.setText(students2.toString());
                    break;
            }
        }
    }


