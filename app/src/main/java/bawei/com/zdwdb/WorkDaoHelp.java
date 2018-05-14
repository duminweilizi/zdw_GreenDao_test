package bawei.com.zdwdb;

import android.content.Context;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

import bawei.com.greedaotest.dao.ZdwWorkDao;
import bawei.com.zdw_greendao_test.ZdwWork;

/**
 * Created by dell on 2018/5/14.
 */

public class WorkDaoHelp {
    /**
     * 添加数据至数据库
     *
     * @param context
     * @param zdwWork
     */
    public static void insertData(Context context, ZdwWork zdwWork) {
        DbManager.getDaoSession(context).getZdwWorkDao().insert(zdwWork);
    }


    /**
     * 将数据实体通过事务添加至数据库
     *
     * @param context
     * @param list
     */
    public static void insertData(Context context, List<ZdwWork> list) {
        if (null == list || list.size() <= 0) {
            return;
        }
        DbManager.getDaoSession(context).getZdwWorkDao().insertInTx(list);
    }

    /**
     * 添加数据至数据库，如果存在，将原来的数据覆盖
     * 内部代码判断了如果存在就update(entity);不存在就insert(entity)；
     *
     * @param context
     * @param zdwWork2
     */
    public static void saveData(Context context, ZdwWork zdwWork2) {
        DbManager.getDaoSession(context).getZdwWorkDao().save(zdwWork2);
    }

    /**
     * 删除数据至数据库
     *
     * @param context
     * @param zdwWork2 删除具体内容
     */
    public static void deleteData(Context context, ZdwWork zdwWork2) {
        DbManager.getDaoSession(context).getZdwWorkDao().delete(zdwWork2);
    }

    /**
     * 根据id删除数据至数据库
     *
     * @param context
     * @param id      删除具体内容
     */
    public static void deleteByKeyData(Context context, long id) {
        DbManager.getDaoSession(context).getZdwWorkDao().deleteByKey(id);
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleteAllData(Context context) {
        DbManager.getDaoSession(context).getZdwWorkDao().deleteAll();
    }

    /**
     * 更新数据库
     *
     * @param context
     * @param zdwWork2
     */
    public static void updateData(Context context, ZdwWork zdwWork2) {
        DbManager.getDaoSession(context).getZdwWorkDao().update(zdwWork2);
    }


    /**
     * 查询所有数据
     *
     * @param context
     * @return
     */
    public static List<ZdwWork> queryAll(Context context) {
        QueryBuilder<ZdwWork> builder = DbManager.getDaoSession(context).getZdwWorkDao().queryBuilder();

        return builder.build().list();
    }



    /**
     *  分页加载
     * @param context
     * @param pageSize 当前第几页(程序中动态修改pageSize的值即可)
     * @param pageNum  每页显示多少个
     * @return
     */
    public static List<ZdwWork> queryPaging( int pageSize, int pageNum,Context context){
        ZdwWorkDao zdwWorkDao = DbManager.getDaoSession(context).getZdwWorkDao();
        List<ZdwWork> listMsg = zdwWorkDao.queryBuilder()
                .offset(pageSize * pageNum).limit(pageNum).list();
        return listMsg;
    }
}
