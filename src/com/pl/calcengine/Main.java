package com.pl.calcengine;

public class Main {

    public static void main(String[] args) {
        //to use enum n String builder we moved the previous methods
        //useMathEquation();
        //useCalculationBase();
        //useCaliculateHelper();
        String[] statements = {
            "add 25.0 90.0",
                "power 25.0 5.0"
        };

        DynamicHelper helper=new DynamicHelper(new MathProcessing[]{
           new Adder(),new PowerOf()
        });
        for(String statement:statements){
        String output=helper.process(statement);
        System.out.println(output);
        }
    }
        static void useCaliculateHelper(){
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addx 0.0,0.0",
                "divide 100.0 50.0",
                "add 100.0 50.0",
                "subtract 100.0 50.0",
                "multiply 100.0 5.0"
        };
        CalculateHelper helper = new CalculateHelper();
        for(String statement:statements){
            try {
                helper.process(statement);
                System.out.println(helper);
            }catch (InvalidStatementException e){
                System.out.println(e.getMessage());
                if(e.getCause()!=null)
                    System.out.println("Original exception:"+e.getCause().getMessage());
            }
        }
    }
    static void useMathEquation(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 70.0d, 25.0d);
        equations[2] = new MathEquation('s', 70.0d, 25.0d);
        equations[3] = new MathEquation('m', 7.0d, 25.0d);
     /*   equations[0]=create(100.0d,50.0d,'d');
        equations[1]=create(70.0d,25.0d,'a');
        equations[2]=create(70.0d,25.0d,'s');
        equations[3]=create(7.0d,25.0d,'m');
       /* double[] leftVals={100.0d,25.0d,225.0d,11.0d};
        double[] rightVals={50.0d,92.0d,25.0d,3.0d};
        char[] opCode={'d','a','s','m'};
	        double[] result=new double[opCode.length] ;

        for(int i=0;i<opCode.length;i++) {
           /* switch(opCode[i]){
                case 'a':
                result[i] = leftVals[i]+rightVals[i];
                break;
                case 's':
                result[i] = leftVals[i]-rightVals[i];
                break;
                case 'm':
                result[i] = leftVals[i]*rightVals[i];
                break;
                case 'd':
                result[i] = rightVals[i]!=0.0d ? leftVals[i]/rightVals[i]: 0.0d;
                break;
                default:
                result[i] = 0.0d;
                break;
            }*/
        for (MathEquation equation : equations) {
            equation.execute();
            System.out.print("result= ");
            System.out.println(equation.getResult());
        }
        System.out.println("Using Overloads");
        double left=9.0d;
        double right=4.0d;
MathEquation equationOverload=new MathEquation('d');
        equationOverload.execute(left,right);
        System.out.print("result= ");
        System.out.println(equationOverload.getResult());

  /* public static MathEquation create(double leftVal,double rightVal,char opCode){
        MathEquation equation=new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
   }*/
        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

CalculateBase[] calculators={
        new Divider(100.0d,50.0d),
        new Adder(100.0d,50.0d),
        new Subtracter(100.0d,50.0d),
        new Multiplier(100.0d,5.0d)
};
for(CalculateBase calculator:calculators){
    calculator.calculate();
    System.out.print("result=");
    System.out.println(calculator.getResult());
}

    }
}

