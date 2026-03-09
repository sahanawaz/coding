
void printMenu() {
    IO.println("""
        Select from the options
        1. Capitalize First Letter
        2. Group Employee By Email Domain
        3. Group String based of First Character of String
    """);
}

void runCapitalizeFirstLetter() {
    CapitalizeFirstLetter cfl = new CapitalizeFirstLetter();
    cfl.printCapitalizedOutput(cfl.capitalizeWords(cfl.readInputFromUser()));
    cfl.printCapitalizedOutput(cfl.capitalizeUsingStream(cfl.readInputFromUser()));
}

void runGroupingEmployeeByDomain() {
    GroupEmployeeByEmailDomain ge = new GroupEmployeeByEmailDomain();
    ge.groupEmployeeByDomain(ge.initializeEmployee());
}

void runGroupStringByFirstLetter() {
    GroupStringOnFirstLetter gfl = new GroupStringOnFirstLetter();
    gfl.groupStringOnFirstLetter();
}

void main() {
    printMenu();
    String option = IO.readln();

    switch (option) {
        case "1" -> runCapitalizeFirstLetter();
        case "2" -> runGroupingEmployeeByDomain();
        case "3" -> runGroupStringByFirstLetter();
        default -> IO.println("Wrong option!!");
    }

}