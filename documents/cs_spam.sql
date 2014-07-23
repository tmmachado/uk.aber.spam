select *--sas.STUD_REF, sub1.TotalActivities, sub2.TotalAttended
from SAMS_ACTIVITY_STUDENTS sas,
  (
    select sas.ACTIVITY_ID, sas.WEEK_NUMBER, count(sas.ACTIVITY_ID) TotalActivities
    from SAMS_ACTIVITY_STUDENTS sas
    inner join SAMS_ACTIVITY sa on sa.ACTIVITY_ID = sas.ACTIVITY_ID and sa.WEEK_NUMBER = sas.WEEK_NUMBER
    where sa.STARTDATETIME between TO_DATE('01-11-2013', 'dd-mm-yyyy') and TO_DATE('15-11-2013', 'dd-mm-yyyy')
    group by sas.STUD_REF, sas.ACTIVITY_ID, sas.WEEK_NUMBER
  ) sub1,
  (
    select sas.ACTIVITY_ID, sas.WEEK_NUMBER, count(sas.ACTIVITY_ID) TotalAttended
    from SAMS_ACTIVITY_STUDENTS sas
    inner join SAMS_ACTIVITY sa on sa.ACTIVITY_ID = sas.ACTIVITY_ID and sa.WEEK_NUMBER = sas.WEEK_NUMBER
    inner join SAMS_ACTIVITY_ATTENDANCE aa on aa.ACTIVITY_ID = sas.ACTIVITY_ID and aa.WEEK_NUMBER = sas.WEEK_NUMBER
    where (sa.STARTDATETIME between TO_DATE('01-11-2013', 'dd-mm-yyyy') and TO_DATE('15-11-2013', 'dd-mm-yyyy')) and aa.ATTENDED = 'Y'
    group by sas.STUD_REF, sas.ACTIVITY_ID, sas.WEEK_NUMBER
  ) sub2
where sas.ACTIVITY_ID = sub1.ACTIVITY_ID
  and sas.WEEK_NUMBER = sub1.WEEK_NUMBER
  and sas.ACTIVITY_ID = sub2.ACTIVITY_ID
  and sas.WEEK_NUMBER = sub1.WEEK_NUMBER;