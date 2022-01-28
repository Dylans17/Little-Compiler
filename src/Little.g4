lexer grammar Little;

/*----------------------
 * Fragment Definitions
 *----------------------*/
fragment DIGIT : [0-9] ;
fragment CHAR : [a-zA-Z] ;
fragment ALNUM : DIGIT | CHAR ;

/*----------------------
 * Token Definitions
 *----------------------*/
KEYWORD : 'PROGRAM' | 'BEGIN' | 'END' | 'FUNCTION' | 'READ' | 'WRITE' | 'IF' |
         'ELSE' | 'ENDIF' | 'WHILE' | 'ENDWHILE' | 'CONTINUE' | 'BREAK' |
         'RETURN' | 'INT' | 'VOID' | 'STRING' | 'FLOAT' ;

FLOATLITERAL : DIGIT+.DIGIT* | DIGIT*.DIGIT+ ;
INTLITERAL : DIGIT+ ;
STRINGLITERAL : '"' ~'"'* '"' ;
OPERATOR : ':=' | '+' | '-' | '*' | '/' | '=' | '!=' | '<' | '>' | '(' | ')' |
           ';' | ',' | '<=' | '>=' ;
IDENTIFIER : CHAR ALNUM* ;

/*----------------------
 * Things to Skip
 *----------------------*/
COMMENT : '--' ~'\n'* '\n' -> skip ;
WHITESPACE : [ \t\r\n]+ -> skip ;
