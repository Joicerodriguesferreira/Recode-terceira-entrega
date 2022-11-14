using Microsoft.EntityFrameworkCore;
namespace AgenciaApplication.Models
{
    public class DestinoDbContext : DbContext
    {

        public DestinoDbContext(DbContextOptions<DestinoDbContext> options) : base(options)
        { }

        // RELACIONADO � TABELA DO BD
        public DbSet<Destinos> Destinos { get; set; }

    }
}