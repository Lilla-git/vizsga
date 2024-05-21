using gyakorlas.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace gyakorlas.Controllers
{
    public class CategoryController : ApiController
    {
        // GET api/<controller>
        public List<Category> Get()
        {
            try
            {
                using(NorthwindEntities  db= new NorthwindEntities())
                {
                    return db.Categories.ToList();
                }
            }
            catch (Exception)
            {

                throw;
            }
        }

        // GET api/<controller>/5
        public Category Get(int id)
        {
            try
            {
                using (NorthwindEntities db = new NorthwindEntities())
                {
                    return db.Categories.First(q=>q.CategoryID==id);
                }
            }
            catch (Exception)
            {

                throw;
            }
        }

        // POST api/<controller>
        public void Post([FromBody] Category category)
        {
            try
            {
                using (NorthwindEntities db = new NorthwindEntities())
                {
                    db.Categories.Add(category);
                    db.SaveChanges();
                }
            }
            catch (Exception)
            {

                throw;
            }
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody] Category category)
        {
            try
            {
                using (NorthwindEntities db = new NorthwindEntities())
                {

                   Category o=db.Categories.First(q=>q.CategoryID==id);
                   o.CategoryName= category.CategoryName;
                   o.Description= category.Description;
                   o.Picture= category.Picture;
                   db.SaveChanges();
                }
            }
            catch (Exception)
            {

                throw;
            }
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
            try
            {
                using (NorthwindEntities db = new NorthwindEntities())
                {

                    Category o = db.Categories.First(q => q.CategoryID == id);
                    db.Categories.Remove(o);
                    db.SaveChanges();
                }
            }
            catch (Exception)
            {

                throw;
            }
        }
    }
}