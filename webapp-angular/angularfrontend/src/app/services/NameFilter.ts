import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'appFilterName'})
export class NameFilter implements PipeTransform
{
    transform(items: any[], searchText: string): any[] {
        if(!items)
        {
            return [];
        }

        if(!searchText)
        {
            return items;
        }

        searchText = searchText.toLocaleLowerCase();

        return items.filter(item => {
            return item.hospital.hospitalName.toLocaleLowerCase().includes(searchText);
        });
    }
}