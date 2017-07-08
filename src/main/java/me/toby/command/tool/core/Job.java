
package me.toby.command.tool.core;

import org.apache.commons.cli.*;

import java.util.Collection;
import java.util.Iterator;

/**
 * 类Job.java的实现描述：job 抽象类
 * 
 * @author yaoguang.du 2017年7月7日 下午2:06:08
 */
public abstract class Job {

    /**
     * options
     */
    private static final Options options = new Options();

    /**
     * 注入options
     * 
     * @param opts
     */
    public static void registerOption(Options opts) {

        if (opts == null) {
            options.addOption("h", "help", false, "Print usage instructions");
            return;
        }

        Collection<Option> colls = opts.getOptions();
        if (colls != null) {
            if (!opts.hasOption("help") && !options.hasOption("help")) {
                options.addOption("h", "help", false, "Print usage instructions");
            }
            Iterator<Option> it = colls.iterator();

            while (it.hasNext()) {
                options.addOption(it.next());
            }
        }

    }

    /**
     * @return total options
     */
    protected static Options getOptions() {
        return options;
    }

    /**
     * parse args to options
     * 
     * @param args
     * @param stopAtNonOption false:如果有未指定参数则停止,true 不停止
     * @return
     * @throws ParseException
     */
    protected static CommandLine parse(String[] args, boolean stopAtNonOption) throws ParseException {

        CommandLineParser parser = new DefaultParser();
        CommandLine cmdLine = parser.parse(getOptions(), args, stopAtNonOption);

        return cmdLine;
    }

    /**
     * 开始任务
     * 
     * @param args
     * @throws Exception
     */
    public abstract void run(String[] args) throws Exception;

    /**
     * 应用命令行选项
     * 
     * @param baseOptions
     * @param cmdLine
     * @throws Exception
     */
    public void applyOptions(Options baseOptions, CommandLine cmdLine) throws Exception {
    }

}
