using RestTest.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using RestTest.Services;

namespace RestTest.Controllers
{
    public class ContactController : ApiController
    {
        private ContactRepository contactRepository;

        public ContactController()
        {
            this.contactRepository = new ContactRepository();
        }

        public Contact[] Get()
        {
            return contactRepository.GetAllContacts();
        }

        public HttpResponseMessage Post(Contact contact)
        {
            this.contactRepository.SaveContact(contact);

            var response = Request.CreateResponse<Contact>(System.Net.HttpStatusCode.Created, contact);

            return response;
        }
    }
}
