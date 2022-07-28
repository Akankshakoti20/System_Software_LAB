%{
#include<stdio.h>
#include<stdlib.h>
int iden=0,opr=0,keys=0;
extern FILE*yyin;
int yylex();
int yyerror();
%}
%token id key op
%%
input:id input{iden++;}
|op input{opr++;}
|key input{keys++;}
|id	{iden++;}
|op	{opr++;}
|key	{keys++;}
;
%%
void main()
{
yyin=fopen("prg6b.txt","r");
yyparse();
printf("Key count=%d \n",keys);
printf("Operator count=%d \n",opr);
printf("Identifiers count=%d \n",iden);
}
int yyerror()
{
printf("invalid");
return 1;
}

