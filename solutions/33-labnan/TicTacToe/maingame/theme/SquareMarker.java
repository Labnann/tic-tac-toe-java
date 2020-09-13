package maingame.theme;

 interface CrossMark {
     Object getCrossMark();
}
class TextCross implements CrossMark{
     @Override
     public Object getCrossMark(){
         return "X";
     }
}
