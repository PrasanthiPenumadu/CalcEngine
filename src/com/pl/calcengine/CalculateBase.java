package com.pl.calcengine;

public abstract class CalculateBase {
    private double leftVal;
    private double rightVal;
    private double result;

    public double getLeftVal(){    return leftVal;}//accessor
    public  void  setLeftVal(double leftVal){this.leftVal=leftVal;}//mutator
    public  double getRightVal(){return rightVal;}
    public  void  setRightVal(double rightVal){this.rightVal=rightVal;}
      public  double getResult(){return  result;}
      public  void setResult(double result) {this.result=result;}

      public  CalculateBase(){}
    public  CalculateBase(double leftVal,double rightVal){
        this.leftVal=leftVal;
        this.rightVal=rightVal;
    }

    public  abstract void  calculate();
}
