SELECT User_ID, Advertisement_ID, AdvTitle, AdvDetails, Price, S.Status_Name, AdvDateTime FROM Advertisements A INNER JOIN Statuses S ON A.Status_ID=S.Status_ID WHERE User_ID=3;