
package me.toby.command.tool.core;


import me.toby.command.tool.tools.HelpTool;

/**
 * 类ToolStarter.java的实现描述：启动类
 *
 * @author yaoguang.du 2017年7月8日 下午12:38:39
 */
public class Starter {

    /**
     * 私有构造
     */
    private Starter() {

    }

    /**
     * 加载工具类
     */
    static {
        BaseTool.registerJob("help", HelpTool.class, "Print usage instructions", false);
    }

    /**
     * 注册工具类
     *
     * @param toolName
     * @param clazz
     * @param desc
     * @param hasArg
     * @throws Exception
     */
    public static void registerJob(String toolName, Class<? extends Job> clazz, String desc, boolean hasArg)
            throws Exception {
        BaseTool.registerJob(toolName, clazz, desc, hasArg);
    }

    /**
     * 启动
     *
     * @param args
     */
    public static void start(String[] args) {

        try {
            BaseTool.start(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
