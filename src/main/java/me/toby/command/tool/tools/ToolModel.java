
package me.toby.command.tool.tools;

import me.toby.command.tool.core.Job;

import java.io.Serializable;


/**
 * 类ToolModel.java的实现描述：工具类模型
 *
 * @author yaoguang.du 2017年7月7日 下午3:09:27
 */
public class ToolModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String name;

    private String desc;

    private Class<? extends Job> clazz;

    public ToolModel() {

    }


    /**
     * @param name
     * @param desc
     * @param clazz
     */
    public ToolModel(String name, String desc, Class<? extends Job> clazz) {
        super();
        this.name = name;
        this.desc = desc;
        this.clazz = clazz;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the clazz
     */
    public Class<? extends Job> getClazz() {
        return clazz;
    }

    /**
     * @param clazz the clazz to set
     */
    public void setClazz(Class<? extends Job> clazz) {
        this.clazz = clazz;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
