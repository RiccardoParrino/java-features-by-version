int add(int a, int b) {
    return a+b;
}

int multiply(int a, int b) {
    return a*b;
}

Scanner in = new Scanner(System.in);

while(true) {
    System.out.println("Menu:");
    System.out.println("- type add a b to add two number");
    System.out.println("- type mul a b to multiply two number");
    System.out.println("- type esc to close the app");
    String s = in.nextLine();
    String[]input = s.split("\\s+");

    if (input[0].equals("add")) {
        System.out.println( add( Integer.valueOf(input[1]), Integer.valueOf(input[2]) ) );
    } else if ( input[0].equals("mul") ) {
        System.out.println( multiply( Integer.valueOf(input[1]), Integer.valueOf(input[2]) ) );
    } else {
        break;
    }
}

// to execute jshell --execution local example2.jsh