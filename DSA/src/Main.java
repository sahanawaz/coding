
void printMenu() {
    IO.println("""
        Select from the options
        1. Beautiful Game
        2. Run Automated Beautiful Game
        3. Print Lucky No from Array A
    """);
}

void runBeautifulGame() {
    IO.println("Enter the string for Beautiful Game: ");
    String inpStr = IO.readln();
    BeautifulGame bg = new BeautifulGame();
    IO.println(bg.lookForBeautiful(inpStr));
}

void runAutomatedBeautifulGame() {
    BeautifulGame bg = new BeautifulGame();
    bg.runTest();
}

void runLuckyNo() {
    IO.println("Enter the size of the array A: ");
    try {
        int N = Integer.parseInt(IO.readln());
        IO.println("Enter the elements of the array: ");
        int[] A = new int[N];
        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(IO.readln());
        }
        LuckyOne lo = new LuckyOne();
        IO.println("Lucky No: " + lo.getLuckyNo(N, A));
    } catch (NumberFormatException nfe) {
        IO.println("Please input integer values!!");
    }

}

void main() {
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    printMenu();
    String option = IO.readln();

    switch (option) {
        case "1" -> runBeautifulGame();
        case "2" -> runAutomatedBeautifulGame();
        case "3" -> runLuckyNo();
        default -> IO.println("Wrong option!!");
    }

}
