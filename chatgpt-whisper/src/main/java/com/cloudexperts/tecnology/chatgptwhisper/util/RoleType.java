package com.cloudexperts.tecnology.chatgptwhisper.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {
    SYSTEM("system"),
    USER("user"),
    ASSISTANT("assistant");
    private String value;

    public static boolean getByValue(String value){
        boolean result = false;
        for (RoleType myEnum: RoleType.values()) {
            if(myEnum.getValue().equalsIgnoreCase(value)){
                result = true;
            }
        }
        return result;
    }

}
