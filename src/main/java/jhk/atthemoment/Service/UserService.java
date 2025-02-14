package jhk.atthemoment.Service;

import jhk.atthemoment.DTO.RequestAuth;
import jhk.atthemoment.DTO.ResponseAuth;
import jhk.atthemoment.DTO.User;
import jhk.atthemoment.Enum.Role;
import jhk.atthemoment.Repository.UserRepository;
import jhk.atthemoment.Util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public void register(RequestAuth request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("이미 존재하는 사용자입니다.");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);

        userRepository.save(user);
    }

    public ResponseAuth login(RequestAuth request) {
        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("유저를 찾을 수 없습니다."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("비밀번호가 틀렸습니다.");
        }

        String token = jwtUtil.generateToken(user);
        return new ResponseAuth(token);
    }
}

