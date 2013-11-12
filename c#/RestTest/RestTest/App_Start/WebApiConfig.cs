﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;

namespace RestTest
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "api/{controller}/{id}",
                defaults: new { id = RouteParameter.Optional }
            );

            var appXmlType = config.Formatters.XmlFormatter.SupportedMediaTypes.FirstOrDefault(t => t.MediaType == "application/xml");
            config.Formatters.XmlFormatter.SupportedMediaTypes.Remove(appXmlType);

            // Heben Sie die Kommentierung der folgenden Codezeile auf, um Abfrageunterstützung für Aktionen mit dem Rückgabetyp "IQueryable" oder "IQueryable<T>" zu aktivieren.
            // Damit die Verarbeitung unerwarteter oder böswilliger Abfragen vermieden wird, verwenden Sie die Überprüfungseinstellungen für "QueryableAttribute" zum Überprüfen eingehender Abfragen.
            // Weitere Informationen finden Sie unter "http://go.microsoft.com/fwlink/?LinkId=279712".
            //config.EnableQuerySupport();

            // Wenn Sie Ablaufverfolgung in Ihrer Anwendung deaktivieren möchten, kommentieren Sie die folgende Codezeile aus, oder entfernen Sie sie.
            // Weitere Informationen finden Sie unter: http://www.asp.net/web-api
            config.EnableSystemDiagnosticsTracing();
        }
    }
}
