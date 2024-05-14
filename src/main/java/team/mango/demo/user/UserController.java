package team.mango.demo.user;
import team.mango.demo.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        // 사용자 정보 검증
        if (!userService.isEmailUnique(userDTO.getEmail())) {
            return ResponseEntity.badRequest().body("중복된 이메일 주소입니다.");
        }

        // 사용자 등록
        userService.registerUser(userDTO);

        return ResponseEntity.ok("사용자 등록이 완료되었습니다.");
    }
}
