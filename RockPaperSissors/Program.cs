using System;
using System.Globalization;
using static System.Console;
namespace ConsoleApplication2
{
    internal static class RockPaperSissors
    {
        public static void Main(string[] args)
        {
            Random ranNumberGenerator = new Random();
            int randomNumber;
            randomNumber = ranNumberGenerator.Next(0, 4);
            String s = ReadLine();
            if(s == "r"){
                if(randomNumber == 1){WriteLine("you win");}
                else{WriteLine("you lose");}
            }else if( s == "s"){
                
                if(randomNumber == 2){WriteLine("you win");}
                else{WriteLine("you lose");}
            }else if( s == "p"){
                if(randomNumber == 3){WriteLine("you win");}
                else{WriteLine("you lose");}
            }else{
                WriteLine("error");
            }
        
        }
    }
}