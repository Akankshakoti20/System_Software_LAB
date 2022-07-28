%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
int yyerror();
%}
%token A B ENTER
%%
input:S ENTER {printf("Correct Grammar");exit(0);}
S:C B |B
C:A C |A
;
%%
void main()
{
printf("Enter the string");
yyparse();
}
int yyerror()
{
printf("Invalid Grammar");
return 1;
}
