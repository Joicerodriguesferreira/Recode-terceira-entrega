using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;
using Microsoft.VisualBasic;
using Microsoft.EntityFrameworkCore.Storage;

namespace AgenciaApplication.Models
{

    [Table("Destinos")]
    public class Destinos
    {
        [Key]
        public int DestinoId { get; set; }

        [Required(ErrorMessage = "Informe a url da imagem de destino")]
        public string Imagem { get; set; }

        [Required(ErrorMessage = "Informe onde será o embarque")]
        [StringLength(20)]
        public string Embarque { get; set; }

        [Required(ErrorMessage = "Informe o destino")]
        [StringLength(20)]
        public string Destino { get; set; }
        public class DestinosViewModel
    {

            [Required(ErrorMessage = "Informe a data de Ida - PADRÃO AAAA-MM-DD")]
            [StringLength(10)]
            public string DataIda { get; set; }
            public string? RequestId { get; set; }

            [Required(ErrorMessage = "Informe a data de volta - PADRÃO AAAA-MM-DD")]
            [StringLength(10)]
            public string DataVolta { get; set; }

            [Required(ErrorMessage = "Informe o preço")]
            public float Preco { get; set; }

            [Required(ErrorMessage = "Informe a quantidade disponível")]
            public int QuantidadeDisponivel { get; set; }


            public bool ShowRequestId => !string.IsNullOrEmpty(RequestId);
    }
}