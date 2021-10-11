package capstone.gitime.api.controller;

import capstone.gitime.api.common.annotation.Token;
import capstone.gitime.api.controller.dto.AfterLoginGithubRequestDto;
import capstone.gitime.api.service.SyncService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping("/api/v1/sync")
public class SyncController {

    private final SyncService syncService;

    @GetMapping("/github")
    @ResponseStatus(value = HttpStatus.OK)
    public String syncGithub(@RequestParam("code") String code) throws JsonProcessingException {
        Long memberId = new Long(3L);
        syncService.getTokenByGithub(code, memberId);
        return "OK!";
    }
}
