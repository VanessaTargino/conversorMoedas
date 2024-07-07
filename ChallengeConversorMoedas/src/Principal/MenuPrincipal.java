package Principal;

public class MenuPrincipal {
    private String menu;

    public MenuPrincipal() {
        this.menu = "\nMenu de Operações:\n" +
                "\n1. Converter Real(BRL) para Dólar(USD)\n" +
                "2. Converter Dólar(USD) para Real(BRL)\n" +
                "3. Converter Real(BRL)para Euro(EUR)\n" +
                "4. Converter Euro(EUR) para Real(BRL)\n" +
                "5. Converter Real(BRL) para Libra(GBP)\n" +
                "6. Converter Libra(GBP) para Real(BRL)\n" +
                "7. Sair\n" +
                "\nDigite a opção desejada: ";
    }

    public String getMenu() {
        return menu;
    }
}

