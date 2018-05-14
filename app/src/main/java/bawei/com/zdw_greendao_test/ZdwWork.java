package bawei.com.zdw_greendao_test;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by dell on 2018/5/14.
 */
@Entity
public class ZdwWork {
    @Id
    private Long id;
    @NotNull
    private String name;
    private int age;
    private String num;
    @Generated(hash = 1748218608)
    public ZdwWork(Long id, @NotNull String name, int age, String num) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.num = num;
    }
    @Generated(hash = 2016902358)
    public ZdwWork() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getNum() {
        return this.num;
    }
    public void setNum(String num) {
        this.num = num;
    }
}
