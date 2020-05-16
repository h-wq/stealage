package com.xupt.read.agentManger;

import java.util.ArrayList;
import java.util.Random;

/**
 * @description： user-agent仓库
 */
public class AgentStore {
    private static ArrayList<String> agent  = new ArrayList();
    private static Random random = new Random();

    static {
        agent.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.149 Safari/537.36");
        agent.add("Mozilla/5.0 (iPad; CPU OS 11_0 like Mac OS X) AppleWebKit/604.1.34 (KHTML, like Gecko) Version/11.0 Mobile/15A5341f Safari/604.1");
        agent.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.163 Safari/537.36");
    }

    public static String getUserAgent(){
        int randomNumber = random.nextInt(agent.size());
        return agent.get(randomNumber);
    }
}
