
package me.toby.command.tool.test;

import me.toby.command.tool.core.Starter;

/**
 * 类Tools的实现描述：TODO 类实现描述
 *
 * @author yaoguang.du 2017/7/8 14:29
 */
public class Tools {

    public static void main(String[] args) {
//        Starter. BaseTool.registerJob("demo", DemoTool.class, "demo command", false);

        try {
            Starter.registerJob("demo", DemoTool.class, "demo command", false);
            Starter.start(args);
            System.out.println("finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
