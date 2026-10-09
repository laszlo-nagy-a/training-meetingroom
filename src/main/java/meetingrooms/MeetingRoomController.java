package meetingrooms;

import java.util.List;
import java.util.Scanner;

public class MeetingRoomController {

    private Office office = new Office();

    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MeetingRoomController controller = new MeetingRoomController();
        controller.runMenu();
    }

    private void runMenu() {
        System.out.println("Üdvözöljük");
        System.out.println("Kérem adja meg, hány tárgyalót szerente rögzíteni: ");
        int meetingRoomNumber = sc.nextInt();
        sc.nextLine();
        readMeetingRooms(meetingRoomNumber);
        printMenu();
        int menuItem = sc.nextInt();
        sc.nextLine();
        chooseMenuItem(menuItem);
    }

    private void chooseMenuItem(int menuItem) {
        if(menuItem == 1) {
            System.out.println("A tárgyalók neve sorrendeben:");
            printNames(office.getMeetingRooms());
        }

        if(menuItem == 2) {
            System.out.println("A tárgyalók neve visszafele sorrendben");
            printNames(office.getMeetingRoomsInReverseOrder());
        }

        if(menuItem == 3) {
            System.out.println("Adja meg, hogy páratlan vagy páros sorszámú tárgyalókat szeretne lekérni");
            System.out.println("1. Páratlan:");
            System.out.println("2. Páros:");
            int oddOrEven = sc.nextInt();
            if(oddOrEven == 1) {
                System.out.println("A páratlan számú tárgyalók:");
            }
            if(oddOrEven == 2) {
                System.out.println("A páros számú tárgyalók:");
            }
            printNames(office.getEverySecondMeetingRoom(oddOrEven));
        }

        if(menuItem == 4) {
            System.out.println("A rendszerben található tárgyaló adatai: ");
            printMeetingRooms(office.getMeetingRooms());
        }

        if(menuItem == 5) {
            System.out.println("Adja meg a nevet, amely alapján keresni szeretne: ");
            String name = sc.nextLine();
            System.out.println("A kért tárgyaló adatai:");
            printMeetingRoom(office.getMeetingRoomWithGivenName(name));
        }

        if(menuItem == 6) {
            System.out.println("Adja meg a név töredéket, amely alapján keresni szeretne: ");
            String namePart = sc.nextLine();
            System.out.println("A kért tárgyalók adatai:");
            printMeetingRooms(office.getMeetingRoomsWithGivenNamePart(namePart));
        }

        if(menuItem == 7) {
            System.out.println("Adja meg a területet, amelynél nagyobb tárgyalókra kíváncsi:");
            int area = sc.nextInt();
            sc.nextLine();
            System.out.println("A kért tárgyalók adatai:");
            printMeetingRooms(office.getMeetingRoomWithAreaLargerThan(area));
        }

        if(menuItem == 8) {
            System.out.println("Viszontlátásra");
        }

        if(menuItem < 1 || menuItem > 8) {
            System.out.println("Ismeretlen menüpont");
        }
    }

    private void readMeetingRooms(int meetingRoomNumber) {
        for(int i = 1; i <= meetingRoomNumber; i++) {
            System.out.println("Adja meg a(z) " + i + ". tárgyaló adatait: ");
            System.out.println("Név: ");
            String name = sc.nextLine();
            System.out.println("Szélesség: ");
            int width = sc.nextInt();
            sc.nextLine();
            System.out.println("Hosszúság: ");
            int length = sc.nextInt();
            sc.nextLine();
            office.addMeetingRoom(name, width, length);
            System.out.println("A tárgyaló mentése sikeres volt!");
        }
    }

    private void printMenu() {
        System.out.println("1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján\n" +
                "8. Kilépés");
    }

    private void printNames(List<MeetingRoom> meetingRooms) {
        for(MeetingRoom meetingRoom : meetingRooms) {
            System.out.println(meetingRoom.getName());
        }
    }

    private void printMeetingRooms(List<MeetingRoom> meetingRooms) {
        for(MeetingRoom meetingRoom : meetingRooms) {
           printMeetingRoom(meetingRoom);
        }
    }

    private void printMeetingRoom(MeetingRoom meetingRoom) {
        System.out.println(
                "név: " + meetingRoom.getName() + ", " +
                "szélesség: " + meetingRoom.getWidth() + " m, " +
                "hossz: " + meetingRoom.getLength() + " m, " +
                "terület: " + meetingRoom.getArea() + " m2, "
        );
    }
}
