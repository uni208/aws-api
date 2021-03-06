package com.datadynamics.bigdata.api.service.dynamo;

import com.datadynamics.bigdata.api.service.dynamo.commands.DynamoRequestCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class DynamoRequestDispatcher implements InitializingBean {

    Map<String, DynamoRequestCommand> commandMap;

    List<DynamoRequestCommand> commands;

    public DynamoRequestCommand getCommand(Map<String, String> headers, HttpServletRequest request, String body) {
        String[] entries = body.split("&");
        String command = null;
        for (String entry : entries) {
            if (StringUtils.countOccurrencesOf(entry, "Action=") > 0) {
                command = StringUtils.replace(entry, "Action=", "");
                log.info("Command --> {}", command);
                break;
            }
        }

        if (command == null) {
            throw new UnsupportedOperationException("지원하지 않는 기능입니다.");
        }
        return commandMap.get(command);
    }

    public void setCommands(List<DynamoRequestCommand> commands) {
        this.commands = commands;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (commands == null) {
            throw new IllegalArgumentException("S3 Command를 지정해 주십시오.");
        }

        this.commandMap = new HashMap<>();
        this.commands.forEach(command -> {
            commandMap.put(command.getName(), command);
        });
    }
}
