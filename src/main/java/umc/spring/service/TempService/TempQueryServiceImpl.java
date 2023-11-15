package umc.spring.service.TempService;

import umc.spring.base.Code;
import umc.spring.base.exception.handler.TempHandler;

public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1) {
            throw new TempHandler(Code.TEMP_EXCEPTION);
        }
    }
}
