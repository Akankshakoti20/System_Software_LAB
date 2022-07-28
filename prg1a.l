%{
#include<stdio.h>
int id=0,op=0,brac=0;
%}
%%
[0-9]*		  {id++;printf("\n Identifier");ECHO;}
[+\*] 		 {op++;printf("\n Operator");ECHO;}
"("  		{brac++;}
")" 		 {brac--;}
.  		{;}
%% 
int main()
{
printf("enter the expression");
yylex();
if((op==id-1) && (brac==0))
{
printf("\nValid");
printf("\nthe number of operators is %d",op);
printf("\nthe number of identifiers is %d",id);
}
else 
printf("\nInvalid");
printf("\n");
}
int yywrap()
{
}
