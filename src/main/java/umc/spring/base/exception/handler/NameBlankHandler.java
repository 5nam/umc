package umc.spring.base.exception.handler;

import umc.spring.base.Code;
import umc.spring.base.exception.GeneralException;

public class NameBlankHandler extends GeneralException {
    public NameBlankHandler(Code errorCode) {
        super(errorCode);
    }

}
