Эмитация ввода с клавиатуры при поступлении POST запроса от клиента
Назначение : автоматизация заполнения <input type="file"> при помощи Chrome Extension, выступает в роли исполнителя комманд на клиенской машине

Приложение запускает web server и слушает один единственный URL /rest/key/send/{enter}
Тип запроса POST
В качестве POST параметров принимает {str : "текст"}
В качестве GET параметра идёт Boolean переменная, отвечающая за неообходимость нажатия клавиши Enter после ввода символов

зпускать через javaw -jar sendkey.jar

PS. Не опробовано на графическом окружении Linux (там могут быть ньюансы с буффером обмена который тут применяется), пока уверенно работае только на Windows
