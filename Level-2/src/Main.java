import Ecommerce.EcommerceService;

void printOptions() {
    IO.println("Choose from the below options.");
    IO.println("1. EcommerceService");
}

void runEcommerceService() {
    EcommerceService es = new EcommerceService();
    es.processOrder();
}
void main() {
    printOptions();
    String opt = IO.readln();

    switch (opt) {
        case "1" -> runEcommerceService();
        default -> IO.println("Wrong option!!");
    }
}
