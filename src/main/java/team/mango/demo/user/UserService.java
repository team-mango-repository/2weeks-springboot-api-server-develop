import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isEmailUnique(String email) {
        return userRepository.findByEmail(email) == null;
    }

        public void registerUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        // 비밀번호 암호화 등 추가 작업 필요
        user.setPassword(userDTO.getPassword());
        // 기타 필드 설정...

        userRepository.save(user);
    }
}
