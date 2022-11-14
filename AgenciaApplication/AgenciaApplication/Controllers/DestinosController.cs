using AgenciaApplication.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
using System.Diagnostics;

namespace AgenciaApplication.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DestinoController : ControllerBase
    {
        public class DestinosController : Controller
    {
        private readonly ILogger<DestinosController> _logger;

        public DestinosController(ILogger<DestinosController> logger)
        {
            _logger = logger;
        }
            //lista

            [EnableCors("_myAllowSpecificOrigins")] 
            [HttpGet]
            public IEnumerable<Destinos> GetDestinos()
            {
                return _context.Destinos;
            }
            public IActionResult Index()
        {
            return View();
        }

            //cria 
            [HttpPost]
            public IActionResult CriarDestino(Destinos item)
            {
                if (item == null)
                {
                    return BadRequest();
                }

                _context.Destinos.Add(item);
                _context.SaveChanges();
                return new ObjectResult(item);

                //atualiza
                [HttpPut("{id}")]
                public IActionResult AtualizaDestino(int id, Destinos item)
                {
                    if (id != item.DestinoId)
                    {
                        return BadRequest();
                    }
                    _context.Entry(item).State = EntityState.Modified;
                    _context.SaveChanges();

                    return new NoContentResult();
                }

                //deleta destino id
                [HttpDelete("{id}")]
                public IActionResult DeletaDestino(int id)
                {
                    var destino = _context.Destinos.SingleOrDefault(m => m.DestinoId == id);


                    if (destino == null)
                    {
                        return BadRequest();
                    }


                    _context.Destinos.Remove(destino);
                    _context.SaveChanges();
                    return Ok(destino);
                }

            }
            public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new DestinoViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}