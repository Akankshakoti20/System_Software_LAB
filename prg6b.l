%{
#include"y.tab.h"
#include<stdio.h>
extern int yylval;
%}
%%
[+\-\*\/]	{printf("Operator:%s\n",yytext);return op;}
[a-zA-z]	{printf("Identifiers:%s\n",yytext);return id;}
"void"|"int"	{printf("keyword:%s\n",yytext);return key;}
.  {;}
%%
int yywrap()
{
return 1;
}


