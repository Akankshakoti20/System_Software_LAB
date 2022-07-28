%{
#include<stdio.h>
int i=0,comment1=0,comment2=0;
%}
%%
[/][/].*    {comment1++;}
[/][*]   {if(i==0) i++;}
[*][/]   {if(i==1) i--;comment2++;}
.   {ECHO;}
%%
void main()
{
yyin=fopen("program6a.c","r");
yyout=fopen("output.txt","w");
yylex();
printf("Single line comment is %d \n",comment1);
printf("multiple line comment is %d \n",comment2);
printf("Total number of comments %d \n",comment1+comment2);
}
int yywrap()
{
return 1;
}
