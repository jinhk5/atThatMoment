package jhk.atthemoment.Controller;

import jakarta.validation.Valid;
import jhk.atthemoment.DTO.RequestAuth;
import jhk.atthemoment.DTO.ResponseAuth;
import jhk.atthemoment.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RequestAuth request) {
        userService.register(request);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseAuth> login(@RequestBody RequestAuth request) {
        return ResponseEntity.ok(userService.login(request));
    }
}

