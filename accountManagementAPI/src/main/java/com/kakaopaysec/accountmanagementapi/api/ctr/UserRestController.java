package com.kakaopaysec.accountmanagementapi.api.ctr;

import com.kakaopaysec.accountmanagementapi.api.dto.UserRequestDTO;
import com.kakaopaysec.accountmanagementapi.api.dto.UserResponseDTO;
import com.kakaopaysec.accountmanagementapi.api.svc.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin("*")
@Api(tags = {" 사용자 관리 관련 서비스 컨트롤러"})
@SwaggerDefinition(tags = {
        @Tag(name = "사용자 관리 서비스 컨트롤러", description = "사용자 추가, 조회 이용에 필요한 기능 제공")
})
@RequestMapping("/api/user")
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;


    /**
     * 사용자 추가.
     * @param
     * @return
     */
    @ApiOperation(value="사용자 추가 액션", notes="사용자 ID, 사용자 이름 받아 등록 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PostMapping("/")
    public UserResponseDTO userRegist(@RequestBody UserRequestDTO requestDTO){

        return userService.userRegist(requestDTO);
    }

    /**
     * 사용자 조회.
     * @param
     * @return
     */
    @ApiOperation(value="사용자 정보 조회 액션", notes="사용자 ID를 받아 조회 처리한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 응답"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @GetMapping("/")
    public UserResponseDTO userInfo(@RequestBody UserRequestDTO requestDTO){

        return userService.userSearch(requestDTO);
    }

}
