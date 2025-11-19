package java9.process;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AsyncExitNotificationExample.example();
    }

}

class AsyncExitNotificationExample {

    public static void example() throws IOException {
        ProcessBuilder builder = new ProcessBuilder("ping", "-c", "2", "google.com");
        Process process = builder.start();

        process.toHandle().onExit().thenRun(() -> {
            System.out.println("Process has exited!");
        });

        System.out.println("Waiting for process to finish...");
    }

}

class KillProcessExample {

    public static void example() {
        ProcessHandle.allProcesses()
                .filter(process -> process.info().command().orElse("").contains("Code.exe"))
                .forEach(process -> {
                    System.out.println("Terminating Process ID: " + process.pid());
                    process.destroy();
                });
    }

}

class ChildProcessExample {

    public static void example() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("ping", "-c", "4", "google.com");
        Process process = builder.start();
        ProcessHandle handle = process.toHandle();
        System.out.println("Child Process PID: " + handle.pid());
        handle.onExit().thenRun(() -> System.out.println("Process has exited."));
        process.waitFor();
        System.out.println("Exit value: " + process.exitValue());
    }

}

class ListProcessesExample {

    public static void example() {
        ProcessHandle.allProcesses()
                .forEach(process -> {
                    ProcessHandle.Info info = process.info();
                    System.out.println("PID: " + process.pid());
                    info.command().ifPresent(cmd -> System.out.println("Command: " + cmd));
                });
    }

}

class CurrentProcessExample {

    public static void example() {
        ProcessHandle currentProcess = ProcessHandle.current();
        ProcessHandle.Info info = currentProcess.info();
        System.out.println("Process ID: " + currentProcess.pid());
        info.command().ifPresent(cmd -> System.out.println("Command: " + cmd));
        info.arguments().ifPresent(argsList -> System.out.println("Arguments: " + String.join(", ", argsList)));
        info.startInstant().ifPresent(start -> System.out.println("Start Time: " + start));
        info.totalCpuDuration().ifPresent(cpuTime -> System.out.println("CPU Time: " + cpuTime));
    }

}
