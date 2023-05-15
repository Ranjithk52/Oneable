package com.ojas.spring.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;


@RestController
@RequestMapping("/api/stopwatch")
class StopwatchController {
    private long startTime;
    private boolean running;

    @PostMapping("/start")
    public ResponseEntity<String> start() {
        if (!running) {
            startTime = System.nanoTime();
            running = true;
            return ResponseEntity.ok("Stopwatch started.");
        } else {
            return ResponseEntity.badRequest().body("Stopwatch is already running.");
        }
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stop() {
        if (running) {
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            running = false;
            System.err.println(elapsedTime);
            return ResponseEntity.ok("Stopwatch stopped. Elapsed time: " + formatElapsedTime(elapsedTime));
        } else {
            return ResponseEntity.badRequest().body("Stopwatch is not running.");
        }
    }

    private String formatElapsedTime(long elapsedTime) {
        long millis = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(minutes);
        long milliseconds = millis - TimeUnit.SECONDS.toMillis(seconds);
        return String.format("%02d:%02d:%03d", minutes, seconds, milliseconds);
    }
}
