
package me.toby.command.tool.core;

import me.toby.command.tool.tools.ToolModel;
import org.apache.commons.cli.*;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * 类BaseTool.java的实现描述：command cli工具类基类
 *
 * @author yaoguang.du 2017年7月7日 下午12:21:32
 */
public class BaseTool {


    static final Options options = new Options();

    static final Map<String, ToolModel> tools = new TreeMap<String, ToolModel>();

    public static void start(String[] args) throws Exception {

        try {
            //一级命令
            String action = args[0];

            CommandLineParser parser = new DefaultParser();
            CommandLine cmdLine = parser.parse(options, args, true);

            args = Arrays.copyOfRange(args, 1, args.length);

            ToolModel model = tools.get(action);

            // 命令行第一个命令为tool
            if (model != null) {

                try {
                    Job clazz = model.getClazz().newInstance();
                    clazz.applyOptions(options, cmdLine);
                    clazz.run(args);
                } catch (Exception e) {
                    throw e;
                }

            } else {
                throw new RuntimeException();
            }

        } catch (Exception e) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("help", options, true);
        }

    }


    protected static void registerJob(String toolName, Class<? extends Job> clazz, String desc, boolean hasArg) {
        ToolModel target = tools.get(toolName);

        if (target != null) {
            throw new RuntimeException("tool already existed with name " + toolName);
        }

        tools.put(toolName, new ToolModel(toolName, desc, clazz));
        options.addOption(toolName, hasArg, desc);

    }

}
