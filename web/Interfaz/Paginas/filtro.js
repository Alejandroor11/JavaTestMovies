function Filtrar()
{
    var table = document.getElementById('resultados0');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar2()
{
    var table = document.getElementById('resultados1');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar3()
{
    var table = document.getElementById('resultados2');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar4()
{
    var table = document.getElementById('resultados3');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar5()
{
    var table = document.getElementById('resultados4');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar6()
{
    var table = document.getElementById('resultados5');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar7()
{
    var table = document.getElementById('resultados6');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar8()
{
    var table = document.getElementById('resultados7');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar9()
{
    var table = document.getElementById('resultados8');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar10()
{
    var table = document.getElementById('resultados9');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
function Filtrar11()
{
    var table = document.getElementById('resultados10');
    var filtro = document.getElementById('Txt_filtro').value.toLowerCase();
    filtro = filtro.trim(filtro);
    var cellsOfRow="";
    var found=false;
    var compareWith="";
    // Recorremos todas las filas con contenido de la tabla
    for (var i = 1; i < table.rows.length; i++)
    {
        cellsOfRow = table.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        if (filtro == "") {
            found = false;
        }else{
            for (var j = 0; j < cellsOfRow.length && !found; j++)
            {
                compareWith = cellsOfRow[j].innerHTML.toLowerCase();
                // Buscamos el texto en el contenido de la celda
                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
                {
                    found = true;
                }
            }
        }
        if(found)
        {
            table.rows[i].style.display = '';
        } else {
            if (filtro.length == 0) {
                // i starts from 1 to skip table header row
                    if (i > 10)
                        table.rows[i].style.display = 'none';
                    else
                        table.rows[i].style.display = '';
                       // table.rows[i].style.display = '';
            }else{
                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
                table.rows[i].style.display = 'none';
            }
        }
    }
}
//function Filtrar2(campo)
//{
//    var table = document.getElementById('resultados2');
//    var filtro = campo.options[campo.selectedIndex].innerHTML;
//    filtro = filtro.trim(filtro);
//    var cellsOfRow="";
//    var found=false;
//    var compareWith="";
//    // Recorremos todas las filas con contenido de la tabla
//    for (var i = 1; i < table.rows.length; i++)
//    {
//        cellsOfRow = table.rows[i].getElementsByTagName('td');
//        found = false;
//        // Recorremos todas las celdas
//        if (filtro == "") {
//            found = false;
//        }else{
//            for (var j = 0; j < cellsOfRow.length && !found; j++)
//            {
//                compareWith = cellsOfRow[j].innerHTML.toUpperCase();
//                // Buscamos el texto en el contenido de la celda
//                if (filtro.length == 0 || (compareWith.indexOf(filtro) > -1))
//                {
//                    found = true;
//                }
//            }
//        }
//        if(found)
//        {
//            table.rows[i].style.display = '';
//        } else {
//            if (filtro.length == 0) {
//                // i starts from 1 to skip table header row
//                    if (i > 10)
//                        table.rows[i].style.display = 'none';
//                    else
//                        table.rows[i].style.display = '';
//                       // table.rows[i].style.display = '';
//            }else{
//                // si no ha encontrado ninguna coincidencia, esconde la fila de la tabla
//                table.rows[i].style.display = 'none';
//            }
//        }
//    }
//}
