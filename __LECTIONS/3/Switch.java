public class Switch {

    public static void main(String[] args) {

        String language = "Java";

    }


    public String printLanguage(String language) {
        switch (language) {
            case "Java":
                return "Это джава";
            case "C++":
                System.out.println("Это с++");
                break;
            case "Delphi":
                System.out.println("Это Делфи");
                break;
            default:
                System.out.println("Ветка по умолчанию");
        }
        return "42";
    }
}
