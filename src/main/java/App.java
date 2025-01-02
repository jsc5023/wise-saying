import wiseSaying.SystemController;
import wiseSaying.WiseSayingController;

import java.util.Scanner;

public class App {

    private final WiseSayingController wiseSayingController;
    private final SystemController systemController;
    private final Scanner scanner;

    public App() {
        scanner = new Scanner(System.in);
        wiseSayingController = new WiseSayingController(scanner);
        systemController = new SystemController();
    }

    public void run() {

        wiseSayingController.add("꿈을 지녀라. 그러면 어려운 현실을 이길 수 있다.", "월트 디즈니");
        wiseSayingController.add("현재를 사랑하라", "작자 미상");

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = scanner.nextLine();

            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayingController.writeWiseSaying();
            } else if (command.equals("목록")) {
                wiseSayingController.printWiseSayingList();
            } else if(command.startsWith("삭제?id=")) {
                String strId = command.substring(6);
                int id = Integer.parseInt(strId);
                wiseSayingController.deleteWiseSaying(id);
            } else if(command.startsWith("수정?id=")) {
                String strId = command.substring(6);
                int id = Integer.parseInt(strId);
                wiseSayingController.updateWiseSaying(id);
            }
        }
    }
}