--
-- database : taindb01
-- user : kang
--

-- ========================================================================================
-- TB_CPUINFO

SELECT COUNT(*) FROM TB_CPUINFO;

SELECT * FROM TB_CPUINFO WHERE F_YN = 'Y';






-- ========================================================================================
-- TB_CPUREC

SELECT COUNT(*) FROM TB_CPUREC;

SELECT * FROM TB_CPUREC WHERE F_CPUNM = 'TOTAL';

SELECT TIME(F_DTTM), CEIL(10000 - F_IDL*10000) / 100 AS CPU_USE FROM TB_CPUREC WHERE F_CPUNM = 'TOTAL';





-- ========================================================================================
-- TB_MEMREC

SELECT COUNT(*) FROM TB_MEMREC;

SELECT * FROM TB_MEMREC;

SELECT
	CURRENT_TIME,
	TIME(F_DTTM), 
	DOUBLE(F_AUSE)/1024/1024/1024, 
	DOUBLE(F_USE)/1024/1024/1024, 
	--F_TTL, 
	--F_FRE, 
	--F_USE, 
	--F_AFRE, 
	--F_AUSE, 
	CEIL(F_FREP * 100) / 100, 
	CEIL(F_USEP * 100) / 100 
FROM
	TB_MEMREC
ORDER BY
	F_DTTM DESC
--FETCH FIRST ROW ONLY
--FETCH NEXT 10 ROWS ONLY
--OFFSET 100 ROWS
--OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY
--FETCH FIRST 10 ROWS ONLY
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY
;








-- ========================================================================================
-- TB_DSKREC

SELECT COUNT(*) FROM TB_DSKREC;

SELECT * FROM TB_DSKREC;









































